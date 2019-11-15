package sample;

public class WordCount {
    private Integer count;
    private String word;

    /**
     * This method is a getter
     * @param count
     * @param word
     */
    public WordCount(Integer count, String word){
        this.count = count;
        this.word = word;
    }

    public WordCount() {

    }

    /**
     * getter for count
     * @return
     */
    public Integer getCount(){
        return count;
    }

    /**
     * getter for word
     * @return
     */
    public String getWord(){
        return word;
    }

    /**
     * setter for count
     * @param count
     */
    public void setCount(Integer count){
        this.count = count;
    }

    /**
     * setter for word
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * toString method
     * @return
     */
    @Override
    public String toString(){

        return null;
    }

    /**
     * method to
     * @param var1
     * @param var2
     * @return
     */
    public int sum(int var1, int var2){
        System.out.println("Adding values: " + var1 + " + " + var2);
        return var1 + var2;
    }
}
