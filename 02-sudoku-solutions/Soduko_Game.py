grid = [[1, 0, 0, 0, 0 , 0, 0, 0, 0],
        [0, 2, 0, 0, 0 , 0, 0, 0, 0],
        [0, 0, 3, 0, 0 , 0, 0, 0, 0],
        [0, 0, 0, 4, 0 , 0, 0, 0, 0],
        [0, 0, 0, 0, 5 , 0, 0, 0, 0],
        [0, 0, 0, 0, 0 , 6, 0, 0, 0],
        [0, 0, 0, 0, 0 , 0, 7, 0, 0],
        [0, 0, 0, 0, 0 , 0, 0, 8, 0],
        [0, 0, 0, 0, 0 , 0, 0, 0, 9]]

def check_move(grid, row, col, number):
    for x in range(9):
        if grid[row][x] == number:
            return False
        
    for y in range(9):
        if grid[x][col] == number:
            return False
        
    box_row = row - row % 3
    box_col = col - col % 3
    
    for x in range(3):
        for y in range(3):
            if grid[box_row + x][box_col + y] == number:
                return False
    return True

def solve(grid, row, col):
    if col == 9:
        if row ==8:
            return True
            
        row +=1
        col =0
        
    if grid[row][col] > 0:
        return solve(grid, row, col +1)
    
    for num in range(1, 10):
        if check_move(grid, row, col, num):
            grid[row][col] = num
            
            if solve(grid, row, col +1):
                return True
            


if solve(grid, 0, 0):
    for i in range(9):
        for j in range(9):
            print(grid[i][j], end=" ")
        print()
        
else:
    print("couldnt be solved check num mistake")