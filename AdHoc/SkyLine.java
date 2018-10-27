import java.util.*;

public class SkyLine {
	
	public static void main(String[] args) {

		System.out.println("SkyLine!!!");

		// int[][] arr = {
		// 	{1,11,5},
		// 	{2,6,7},
		// 	{3,13,9},
		// 	{5,15,6},
		// };

		// int[][] arr = { 
		// 	{1,11,5}, 
		// 	{2,6,7}, 
		// 	{3,13,9}, 
		// 	{12,7,16}, 
		// 	{14,3,25},
		// 	{19,18,22}, 
		// 	{23,13,29}, 
		// 	{24,4,28} 
		// };

		int[][] arr = {
			{1,11,5},
		};

		// int[][] res = calcSkyline(arr);
		int[][] res = calcSkylineMerge(arr);

		for(int m = 0; m < res.length; m++) {
			System.out.print(res[m][0]+" "+res[m][1]);
			System.out.println();
		}
	}

	// create list of points from the input, identify if each point is a start or an end
	// iterate through the points and add them to a PQ, using a height flag, add the val whenever the height changes

	static int[][] calcSkyline(int[][] buildingHeights) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(0);
		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
		int[][] edgePoints = new int[buildingHeights.length*2][3];
		int i = 0;

		// iterate through buildingHeights and separate into separate points
		for(int k = 0; k < buildingHeights.length; k++) {
			edgePoints[i][0] = buildingHeights[k][0];
			edgePoints[i][1] = buildingHeights[k][1];
			edgePoints[i][2] = 0;
			i++;
			
			edgePoints[i][0] = buildingHeights[k][2];
			edgePoints[i][1] = buildingHeights[k][1];
			edgePoints[i][2] = -1;
			i++;
		}

		// sort the edgePoints
		edgePoints = arraySort(edgePoints);
		i = 0;
		int currHeight = 0;

		for(int m = 0; m < edgePoints.length; m++) {
			System.out.print(edgePoints[m][0]+" "+edgePoints[m][1]+" "+edgePoints[m][2]);
			System.out.println();
		}

		// iterate through the edgePoints and add the heights to PQ
		for(; i < edgePoints.length; i++) {
			if(edgePoints[i][2] == -1) {
				if(pq.contains(edgePoints[i][1])) {
					System.out.println("Removing: "+edgePoints[i][1]);	
					pq.remove(edgePoints[i][1]);
				} 
			} else {
				System.out.println("Adding: "+edgePoints[i][1]);
				pq.add(edgePoints[i][1]);
			}
			if(pq.size() > 0) {
				if(pq.peek() != currHeight) {
					System.out.println("Peeked: "+pq.peek());				
					currHeight = pq.peek();
					Integer[] point = {edgePoints[i][0], pq.peek()};
					res.add(point);
				}
			}
		}

		int[][] resArr = new int[res.size()][2];

		for(int f = 0; f < resArr.length; f++) {
			resArr[f][0] = res.get(f)[0];
			resArr[f][1] = res.get(f)[1];
		}

		return resArr;
	}

	static int[][] calcSkylineMerge(int[][] buildingHeights) {

		int[][] edgePoints = new int[buildingHeights.length*2][3];
		int i = 0;

		// iterate through buildingHeights and separate into separate points
		for(int k = 0; k < buildingHeights.length; k++) {
			edgePoints[i][0] = buildingHeights[k][0];
			edgePoints[i][1] = buildingHeights[k][1];
			edgePoints[i][2] = 0;
			i++;
			
			edgePoints[i][0] = buildingHeights[k][2];
			edgePoints[i][1] = buildingHeights[k][1];
			edgePoints[i][2] = -1;
			i++;
		}

		return merge(edgePoints, 0, edgePoints.length);
	}

	static int[][] merge(int[][] edges, int l, int r) {
		if(l == r) {
			return edges;
		}
		int mid = (l + r) / 2;
		return mergeUtil(merge(edges, l, mid), merge(edges, mid, r));		
	}

	static int[][] mergeUtil(int[][] sky1, int[][] sky2) {

		// int[][] sky1 = new int[m-1][2];
		// int[][] sky2 = new int[r-m][2];

		ArrayList<int[]> res = new ArrayList<int[]>();

		// int i = 0;
		// // populate the 2 arrays

		// for(; i < sky1.length; i++) {
		// 	sky1[i][0] = edges[l][0];
		// 	sky1[i][1] = edges[l][1];
		// 	l++; 
		// }
		// i = 0;
		// for(; i < sky2.length; i++) {
		// 	sky1[i][0] = edges[m][0];
		// 	sky1[i][1] = edges[m][1];
		// 	m++; 
		// }

		int ptr1 = 0;
		int ptr2 = 0;
		int resPtr = 0;

		while(ptr1 != sky1.length || ptr2 != sky2.length) {

			if(sky1[ptr1][0] < sky2[ptr2][0]) {
				if(res.size() > 0 && (res.get(resPtr-1)[1] == sky1[ptr1][1])) {
					res.remove(resPtr-1);
				}
				res.add(sky1[ptr1]);
				ptr1++;
				resPtr++;
			} else {
				if(res.size() > 0 && (res.get(resPtr-1)[1] == sky2[ptr2][1])) {
					res.remove(resPtr-1);
				}
				res.add(sky2[ptr2]);
				ptr2++;
				resPtr++;
			}
		}

		while(ptr1 != sky1.length) {
			if(res.size() > 0 && (res.get(resPtr-1)[1] == sky1[ptr1][1])) {
				res.remove(resPtr-1);
			}
			res.add(sky1[ptr1]);
			ptr1++;
			resPtr++;			
		}

		while(ptr2 != sky2.length) {
			if(res.size() > 0 && (res.get(resPtr-1)[1] == sky2[ptr2][1])) {
				res.remove(resPtr-1);
			}
			res.add(sky2[ptr2]);
			ptr2++;
			resPtr++;			
		}

		int[][] resArr = new int[res.size()][2];
		for(int k = 0; k < resArr.length; k++) {
			resArr[k][0] = res.get(k)[0];
			resArr[k][1] = res.get(k)[1];
		}

		return resArr;
	}

	static int[][] arraySort(int[][] arr) {
		java.util.Arrays.sort(arr, new java.util.Comparator<int[]>() {
		  public int compare(int[] a, int[] b) {
		    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
		  }
		});
		return arr;
	}

}
