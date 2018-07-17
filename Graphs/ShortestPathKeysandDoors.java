public class ShortestPathKeysandDoors {
	
	public static void main(String[] args) {

		System.out.println("Shortest Path In 2D Grid With Keys And Doors");
		// build the maze

	}


	findPathMain(char[] grid) {

		int[][] res = new int[2][100];
		char[] keys = new char[100];
		int resInd = 0;
		int keyInd = 0;

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '@') {
					Node start = new Node(i,j);
				}
			}
		}

		return findPath(current, res, resInd, keys, keyInd) {

			// if we're at the end then append cell to the res[] and return
			if(grid[current.x][current.y] == '+') {
				res[resInd] = [current.x][current.y];
				return res;
			}

			// if its a door iterate through the keys[] and check if we have the key for it, if not just return
			if(grid[current.x][current.y] == UppercaseChar) {

			}

			//if its a key then add to the keys[] and increment keyInd
			if(grid[current.x][current.y] == LowerCaseChar) {

			}

			//add current element to res[] and increment resInd
			res[resInd] = [current.x][current.y];
			resInd++;

			//iterate through possible moves and call findPath on each if its not water
			for(int k = 0; k < moves.length; k++) {
				Node possible = new Node(current.x + k[0], current.y + k[1]);
				if(grid[possible.x][possible.y] != '#') {
					findPath(possible, res, resInd, keys, keyInd);
				}
			}


		}

	}


}

public class Node {
	
	int x;
	int y;

	Node(int x, int y) {
		x = x;
		y = y;
	}

}