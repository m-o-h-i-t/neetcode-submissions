class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False
        uf = UnionFind(n)
        for u,v in edges:
            if not uf.union(u,v):
                return False
        return True
        


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