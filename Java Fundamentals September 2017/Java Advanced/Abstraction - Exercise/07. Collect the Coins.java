    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.List;

    public class DVS {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<String> matrix = new ArrayList<>();
            matrix.add(scanner.nextLine());
            matrix.add(scanner.nextLine());
            matrix.add(scanner.nextLine());
            matrix.add(scanner.nextLine());
            String moves = scanner.nextLine();
            int hitWalls = 0;
            int coins = 0;
            int row = 0;
            int column = 0;
            if (matrix.get(0).charAt(0) == '$'){
                coins++;
            }
            for (int i = 0; i < moves.length(); i++) {
                if (moves.charAt(i) == '^'){
                    if (row > 0 && column < matrix.get(row-1).length()){
                        row--;
                        if (matrix.get(row).charAt(column) == '$'){
                            String str = matrix.get(row).substring(0,column)+' '+matrix.get(row).substring(column+1);
                            matrix.set(row,str);
                            coins++;
                        }
                    }
                    else {
                        hitWalls++;
                    }
                }
                else if (moves.charAt(i) == 'V'){
                    if (row < matrix.size() -1 && column < matrix.get(row+1).length()){
                        row++;
                        if (matrix.get(row).charAt(column) == '$'){
                            String str = matrix.get(row).substring(0,column)+' '+matrix.get(row).substring(column+1);
                            matrix.set(row,str);
                            coins++;
                        }
                    }
                    else {
                        hitWalls++;
                    }
                }
                else if (moves.charAt(i) == '<'){
                    if (column > 0){
                        column--;
                        if (matrix.get(row).charAt(column) == '$'){
                            String str = matrix.get(row).substring(0,column)+' '+matrix.get(row).substring(column+1);
                            matrix.set(row, str);
                            coins++;
                        }
                    }
                    else {
                        hitWalls++;
                    }
                }
                else if (moves.charAt(i) == '>'){
                    if (column < matrix.get(row).length() - 1 ){
                        column++;
                        if (matrix.get(row).charAt(column) == '$'){
                            String str = matrix.get(row).substring(0,column)+' '+matrix.get(row).substring(column+1);
                            matrix.set(row, str);
                            coins++;
                        }
                    }
                    else {
                        hitWalls++;
                    }
                }
            }
            System.out.println("Coins = " + coins);
            System.out.println("Walls = " + hitWalls);
        }
    }