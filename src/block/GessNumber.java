package block;

public class GessNumber {
    private int answer=0;//生成的随机数
    private int guessNumber=0;//用户猜的数
    private int guessCount=0;//猜的次数
    private String result=null;//返回的结果
    private boolean right=false;//判断标志
    public void setAnswer(int answer) {
                 this.answer=answer;
                 guessCount=0;
             }
    public int getAnswer()
    {
                 return answer;
             }
    public int getGuessNumber() {
                 return guessNumber;
             }
     public int getGuessCount()
     {
                 return guessCount;
             }
     public boolean isRight() {//boolean型需要isxxx()方法
                     return right;
             }
    public void setGuessNumber(int guessNumber) {
                 this.guessNumber=guessNumber;
                 guessCount++;
                 if(guessNumber==answer)
                     {
                         result="恭喜你，猜对了！";
                         right=true;
                     }
                 else if(guessNumber>answer)
                    {
                         result="对不起，你猜大了！";
                         right=false;
                     }
                 else
                {
                        result="对不起，你猜小了！";
                        right=false;
                     }
             }
}
