class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        uf = UnionFind(n+1)
        for u,v in edges:
            if not uf.union(u,v):
                return [u,v]
        return[]
        


class UnionFind:
    def __init__(self,n):
        self.parent = list(range(n))
        self.rank = [0]*n
    

    def find(self, x):
        if(x != self.parent[x]):
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        rx,ry = self.find(x),self.find(y)

        if(rx == ry):
            return False
        
        if(self.rank[rx] > self.rank[ry]):
            self.parent[ry] = rx
        elif(self.rank[rx] < self.rank[ry]):
            self.parent[rx] = ry
        else:
            self.parent[rx] = ry
            self.rank[ry]+=1
        return True
