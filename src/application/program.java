package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

         Board board =new Board(8,8);
        ChessMatch chessMatch = new ChessMatch();

        while (true){
      UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source:     ");
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.println("Target:    ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.perfomaceChessMove(source, target);
        }
    }}

