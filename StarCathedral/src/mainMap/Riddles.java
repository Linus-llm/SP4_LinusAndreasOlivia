package mainMap;
import java.util.ArrayList;

public class Riddles {

    //eksempel paa hvordan en riddle skal opsaettes:
    static {
        ArrayList<String> answerOptions1 = new ArrayList<>();
        answerOptions1.add("A c__n");
        answerOptions1.add("A cr_wn");
        answerOptions1.add("A c_m_t");
        Riddle riddle1 = new Riddle("What has a golden head. It has a golden tail. It has no body?", answerOptions1);

        ArrayList<String> answerOptions2 = new ArrayList<>();
        answerOptions2.add("A sp_ng_");
        answerOptions2.add("A T_w_l");
        answerOptions2.add("A f_n");
        Riddle riddle2 = new Riddle("It dampens as it dries..", answerOptions2);


    }

}
