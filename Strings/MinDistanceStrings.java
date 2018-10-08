Input: abb, d = 2
Input: adbba, d = 3
Output: bab

n = length

// if d doesnt work, return ""

{
    a:1
    b:1
    d:1
}

"ab" "badba"

[a:4, b:3, c:2, d:1] dist = 2

[a:0, b:0, c:0, d:0] dist = 2

abcd




[a:4, b:3, c:2, d:1]
"abcdabcaba"

abcdabcaba
[]

a:8 b:2 c:1 d:0

[a:5, b:3, c:2, d:1] dis = 2
abcdabcabaa xxx

ab ab ab ac ac ad

[a:5, b:3, c:2, d:1]
ab
[a:4, b:2, c:2, d:1]

ab 
[a:3, b:1, c:2, d:1]
ac
a:2 b:1 c:1 d:1
ab
a:1 c:1 d:1


public String findPlacements(String s, int dis) {
    HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
    for(int i = 0; i < s.length(); i++) {
        if(countMap.containsKey(s.charAt(i))) {
            countMap.put(s.charAt(i),countMap.get(s.charAt(i))+1);
        } else {
            countMap.put(s.charAt(i),1);
        }
        
        PriorityQueue<Count> q1 = new PriorityQueue<Count>();
        PriorityQueue<Count> q2 = new PriorityQueue<Count>();
        
        for(int j = 0; j < countMap.size(); j++) {
            q1.add(Count);
        }
        
        while(!q1.isEmpty()) {
            
            for(int k = 0; k < dis; k++) {
                Count currCount = q1.poll();
                if(c)
                res.append(currCount.char);
                currCount.count--;
                q2.add(currCount);
            }
            
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            
        }
    }
}

Count {
    Character:
    Integer:
}

