class Allocator {
    int[] mem;
    int size;
    public Allocator(int n) {
        this.mem = new int[n];
        this.size = n;
    }

    int FindSize(int size){
        int idx = -1;
        int count = 0;
        for (int i = 0; i < this.size; i++){
            if (mem[i] == 0){
                count++;
            }
            else{
                count = 0;
            }
            if (count == size){
                idx = i - size + 1;
                return idx;
            }
        }
        return idx;
    }

    public int allocate(int size, int mID) {
        int idx = FindSize(size);
        if (idx == -1){
            return idx;
        }
        for (int i = idx; i < idx + size; i++){
            this.mem[i] = mID;
        }
        return idx;
    }
    
    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < this.size; i++){
            if (this.mem[i] == mID){
                cnt++;
                this.mem[i] = 0;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Allocator loc = new Allocator(10); // Initialize a memory array of size 10. All memory units are initially free.
        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 0. The memory array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
        System.out.println(loc.allocate(1, 2)); // The leftmost block's first index is 1. The memory array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
        System.out.println(loc.allocate(1, 3)); // The leftmost block's first index is 2. The memory array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
        System.out.println(loc.free(2)); // Free all memory units with mID 2. The memory array becomes [1,_, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
        System.out.println(loc.allocate(3, 4)); // The leftmost block's first index is 3. The memory array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 1. The memory array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 6. The memory array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
        System.out.println(loc.free(1)); // Free all memory units with mID 1. The memory array becomes [_,_,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
        System.out.println(loc.allocate(10, 2)); // We can not find any free block with 10 consecutive free memory units, so we return -1.
        System.out.println(loc.free(7)); // F
    }
}

// [null,0,1,1,0,3,1,1,1,-1,0]