class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        // if bishop is at same position
        if(source[0] == target[0] && source[1] == target[1]) return 0;

        // different colour
        if((source[0] + source[1]) % 2 != (target[0] + target[1]) % 2) return -1;

        // same colour and 1 move
        int rowDiff = Math.abs(source[0] - target[0]);
        int colDiff = Math.abs(source[1] - target[1]);

        if(rowDiff == colDiff) return 1;
        
        return 2;
    }
}