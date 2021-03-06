/**
 * 852. peak index in a mountian array
 * (1)线性搜索，第一个出现 后值比前值小，即返回index
 * （2）二分法，中值与前后比较，挪动前/后指针：note low = mid + 1， 否则会死循环在中值位置。返回low
 */

 // Method 1: linear scan

 class solution{
     public int peakIndexInMountainArray(int[] A){
         if (A == null || A.length == 0) return 0;
         int i = 0;
         while (A[i] < A[i+1])
             i++;
         return i;
     }
 }

 //Method: Binary search

 class Solution{
     public int peakIndexInMountainArray(int[] A){
         int low = 0, hi = A.length - 1;
         while (low < hi){
             int mid = (hi - low)/2 + low;
             if (A[mid] > A[mid +1]){
                 hi = mid;
             }else {
                 low = mid + 1;
             }
         }
         return low;
     }
 }


/**
 * 852. peak index in mountain array
 *   二分查找
 *  一串序列切分，返回最大值的位置
 *  直接二分法 O（log n） 中间位置与中间位置+ 1比较。 如果mid < mid +1 ,做指针移动到mid+1 位置，否则右指针移动mid
 *        NOTE: 1 [low < high] 不可 等于，会死循环。 返回low即为解
 *        NOTE: 2  low = mid + 1; // 将low 移动到 mid+1 位置，否则死循环，（一直都在mid中）
 *  或者 直接 Array搜索 O(n)
 */

 class solution {
     public int peakIndexInMountainArray(int[] A){
         int low = 0, high = A.length - 1;
         while (low < high){
             int mid = (high - low )/2 + low;
             if (A[mid] < A[mid + 1]){
                 low = mid + 1;
             } else {
                 high = mid;
             }
         }
         return low;
     }
 }
