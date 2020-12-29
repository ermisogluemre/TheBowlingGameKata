public class BowlingGame {
    private int roles[] = new int[21];
    private int currentRole = 0;

    public void roll(int pins){
        this.roles[this.currentRole++] = pins;
    }

    public int score(){
        int score = 0;
        int frameIndex = 0;
        for(int frame =0; frame < 10; frame++) {
            if(this.isStrike(frameIndex)){
               score = 10 + this.strikeBonus(frameIndex);
               frameIndex ++;
            }else if(this.isSpare(frameIndex)){//Spare
                score += 10 + this.spareBonus(frameIndex);
                frameIndex += 2;
            }else{
                score += this.sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }


        }
        return score;
    }

    private int sumOfBallsInFrame(int frameIndex){
        return  roles[frameIndex] + roles[frameIndex + 1];
    }

    private int spareBonus(int frameIndex){
        return roles[frameIndex+2];
    }

    private int strikeBonus(int frameIndex){
        return this.roles[frameIndex + 1] + this.roles[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex){
        return (roles[frameIndex] + roles[frameIndex+1]) == 10;
    }

    private boolean isStrike(int frameIndex){
        return this.roles[frameIndex] == 10;
    }
}
