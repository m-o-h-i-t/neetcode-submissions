class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:

        def canShip(weights:List[int], days: int, mid: int) -> bool:
            ships,currCapacity = 1, mid
            for w in weights:
                if currCapacity-w<0:
                    ships+=1
                    if(ships > days):
                        return False
                    currCapacity=mid
                currCapacity-=w
            return True
        l,r = max(weights),sum(weights)
        result = sum(weights)
        while(l<=r):
            mid = (l+r)//2
            if canShip(weights,days,mid):
                result = min(result,mid)
                r=mid-1
            else:
                l=mid+1
        return result
        
        