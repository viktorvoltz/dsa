package arrays;


public class RemoveHighScore {
    static int[] scores = new int[7];

    public static void displayArray(){
        System.out.print("( ");
        for(int i = 0; i < scores.length; i++){
            System.out.print(scores[i] + ", ");
        }
        System.out.print(" )");
        System.out.println();
    }

    public void fillScores(){
        int value = 200;
        for(int i = 0; i < scores.length; i++){
            scores[i] = value;
            value += 50;
        }
        displayArray();
    }

    public int remove(int index) throws IndexOutOfBoundsException {
        int cheatingIndex = index;
        if (index > scores.length){
            throw new IndexOutOfBoundsException("invalid index");
        }

        for(int i = index; i < scores.length - 1; i++){
            scores[i] = scores[i+1];
        }
        
        scores[scores.length - 1] = 0;
        displayArray();

        return cheatingIndex;
    }

    public static void main(String[] args) {
        RemoveHighScore removeHighScore = new RemoveHighScore();
        removeHighScore.fillScores();
        removeHighScore.remove(2);
    }
}
