class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        queens = [-1] * n
        row_oc = set()
        col_oc = set()
        dia_oc = set()
        adia_oc = set()
        results = []

        def is_valid(i, j):
            return i not in row_oc and j not in col_oc and (j - i) not in dia_oc and (i + j) not in adia_oc
        
        def set_a_queen(i,j):
            row_oc.add(i)
            col_oc.add(j)
            dia_oc.add(j - i)
            adia_oc.add(i + j)
            queens[i] = j
            
        def reset_a_queen(i, j):
            row_oc.discard(i)
            col_oc.discard(j)
            dia_oc.discard(j - i)
            adia_oc.discard(i + j)
            queens[i] = -1

        def get_board():
            board = []
            for i in range(n):
                row = ['.'] * n
                row[queens[i]] = 'Q'
                board.append(''.join(row))
            return board
    
        def solve(i):
            for j in range(n):
                if is_valid(i, j):
                    set_a_queen(i, j)
                    if i == (n-1):
                        results.append(get_board())
                    else:
                        solve(i + 1)
                    reset_a_queen(i, j)
        solve(0)
        return results

if __name__ == '__main__':
    s = Solution()
    r = s.solveNQueens(4)
    print('Length of result %s' % len(r))
    print(r)