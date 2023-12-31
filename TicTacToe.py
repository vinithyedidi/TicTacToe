# This program initializes a new game of TicTacToe to be played in the command line. When the game is finished, the
# user can choose to play a new game or not.

# method to print the game board as a 3x3 display.
def printboard(board):
    s = "\033[94m\n"
    for i in range(len(board)):
        s = s + board[i] + " "
        if i == 2 or i == 5:
            s = s + "\n"
    print(s)


# method to take user input 1-9 and enter it as a move
def makemove(player, board):
    print("\033[0m\n" + player + "'s turn. Enter move 1-9.")
    move = input()
    try:
        move = int(move)
    except ValueError:
        print(f'\033[91m{"Please input number from 1 to 9."}\033[0m')
        return 0

    if move > 9 or move < 1:
        print(f'\033[91m{"Please input number from 1 to 9."}\033[0m')
        return 0
    else:
        if board[move-1] == '_':
            board[move-1] = player
            return 1
        else:
            print(f'\033[91m{"Place already taken."}\033[0m')
            return 0


# method to check if a player has won
def checkifwin(board):
    matrix = [['', '', ''],
              ['', '', ''],
              ['', '', '']]
    for i in range(3):
        for j in range(3):
            matrix[i][j] = board[(3*i) + j]

    for k in range(3):
        if matrix[k][0] == matrix[k][1] == matrix[k][2] and matrix[k][1] != '_':
            return True
        elif matrix[0][k] == matrix[1][k] == matrix[2][k] and matrix[1][k] != '_':
            return True
    if matrix[0][0] == matrix[1][1] == matrix[2][2] and matrix[1][1] != '_':
        return True
    elif matrix[0][2] == matrix[1][1] == matrix[2][0] and matrix[1][1] != '_':
        return True
    return False


# method to take user input Y/N and either play again or end game.
def playagain():
    runagain = None
    while runagain is None:
        choice = input("\033[0m\nPlay Again? (Y/N)\n")
        if choice.lower() == 'y':
            runagain = True
        elif choice.lower() == 'n':
            runagain = False
        else:
            print(f'\033[91m{"Please input Y or N"}\033[0m')
            continue
    return runagain


# method to run a new game
def rungame():
    board = ['_', '_', '_',
             '_', '_', '_',
             '_', '_', '_']
    i = 1
    printboard(board)
    while i <= 9:
        if i % 2 == 0:
            player = 'O'
            i = i + makemove(player, board)
        else:
            player = 'X'
            i = i + makemove(player, board)
        if checkifwin(board):
            print("\033[93m\n" + player + " has won!")  # color!
            printboard(board)
            break
        printboard(board)
    if i >= 9:
        print("It's a draw!")


# script to run program
keepRunning = True
while keepRunning:
    rungame()
    keepRunning = playagain()
