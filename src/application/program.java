package application;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

         Board board =new Board(8,8);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()){
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source:     ");
                ChessPosition source = UI.readChessPosition(sc);
                boolean [][] possibleMovies = chessMatch.possibleMovies(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMovies);

                System.out.println();
                System.out.println("Target:    ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.perfomaceChessMove(source, target);
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
            }

            catch (ChessException | InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
        }
    }

