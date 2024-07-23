#include <cstdio>
#include <iostream>

/* Vinith Yedidi
 * July 23, 2024
 * A simple commandline Tic Tac Toe game written in C++.
 */

// size of board: 3x3. Increase this number to play a bigger game.
const int N = 3;

using namespace std;

void printBoard(char** board) {
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            char space = board[row][col];
            if (space != 'X' && space != 'O') {
                cout << ' ';
            } else {
                cout << space;
            }
            if (col != N-1) {
                cout << '|';
            }
        }
        cout << endl;
        if (row != N-1) {
            cout << "—————";
            cout << endl;
        }
    }
    cout << endl;
}


bool makeMove(char**board, char player, int move) {
    bool successfulMove = false;
    int row = (move-1) / N;
    int col = (move-1) % N;
    if (board[row][col] != 'X' && board[row][col] != 'O') {
        board[row][col] = player;
        successfulMove = true;
    }
    return successfulMove;
}


bool checkWin(char** board) {
    bool win = false;

    // diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {win = true;}
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {win = true;}

    // rows and cols
    for (int i = 0; i < N; i++) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {win = true;}
        if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {win = true;}
    }
    return win;
}


void runGame() {
    // initialize board
    char** board = new char*[N];
    for (int h = 0; h < N; h++) {
        board[h] = new char[N];
    }
    // fills spaces with move numbers for reference and to make sure the spaces aren't the same value
    // (for win checker). This is not shown in the gameplay.
    int i = 1;
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            char c = '0' + i;
            board[row][col] = c;
            i++;
        }
    }

    int turn = 1;
    char player = ' ';
    bool win = false;

    // game loop
    while (turn <= 9) {

        if ((turn % 2) == 1) {
            player = 'X';
        } else {
            player = 'O';
        }
        cout << player << "'s turn. Enter move 1-9." << endl;
        printBoard(board);

        // take input 1-9 for move
        int input;
        cin >> input;
        cin.clear();
        cin.ignore(10000,'\n');
        if (cin.fail() || input < 1 || input > 9) {
            cout << "Invalid input. Please try again" << endl;
            continue;
        }
        bool spaceFree = makeMove(board, player, input);
        if (!spaceFree) {
            cout << "Space taken. Please try again." << endl;
            continue;
        }
        // if move was successful, the turn goes to the other player.
        turn++;

        // check win
        win = checkWin(board);
        if (win) {
            printBoard(board);
            cout << player << " has won!" << endl;
            break;
        }
    }
    if (!win) {
        printBoard(board);
        cout << "It's a draw!" << endl;
    }
}


int main() {
    bool keepPlaying = true;

    while (keepPlaying) {
        runGame();
        // after game is done, it requests if players want another game.
        bool validInput = false;
        while (!validInput) {
            cout << "Play again? (Y/N)" << endl;
            char input;
            cin >> input;
            cin.clear();
            cin.ignore(10000,'\n');
            input = toupper(input);
            if (input == 'Y') {validInput = true;}
            else if (input == 'N') {
                    validInput = true;
                    keepPlaying = false;
                    cout << "Thanks for playing!";
            } else {cout << "Invalid input. Please try again." << endl;}
        }
    }
    return 0;
}