#importing the modules
import pprint
import copy  
print("\n SODUKO \n")
#the Actual grid
row_col =  [["5","3",".",".","7",".",".",".","."],
            ["6",".",".","1","9","5",".",".","."],
            [".","9","8",".",".",".",".","6","."],
            ["8",".",".",".","6",".",".",".","3"],
            ["4",".",".","8",".","3",".",".","1"],
            ["7",".",".",".","2",".",".",".","6"],
            [".","6",".",".",".",".","2","8","."],
            [".",".",".","4","1","9",".",".","5"],
            [".",".",".",".","8",".",".","7","9"]]
            
row_index = 0
#z variable to itereate with the grid
z = copy.deepcopy(row_col)
#function 
def minus():
    #nested loop to print the entire elements .
    for row in range(len(row_col)):
        for col in range(len(row_col[0])):
            if row_col [row][col] != "#":
                mine_count = 0
                
                for  x in (-1, 0, 1):
                    for y in (-1, 0, 1):#.replace("[]", "") 
                        if (0 <= row+x < len(row_col) and 
                        0 <= row+y < len(row_col[0]) and 
                        row_col[row+x][col+y] == "-"):
                            mine_count +=1
                z[row][col] = str(mine_count)
    pprint.pprint(z)
#calling back the minus function to print out the minesweeper game
minus()
