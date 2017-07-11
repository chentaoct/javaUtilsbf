package domain;

/**
 * Created by 陈涛 on 2017/7/11.
 */
public class PrizesWeightDomain {
    private String id;
    //奖品名称
    private String prizesName;
    //奖品权重
    private Integer weight;
    //奖品编号
    private String prizesCode;
    //奖品数量
    private Integer num;
    private String extendCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrizesName() {
        return prizesName;
    }

    public void setPrizesName(String prizesName) {
        this.prizesName = prizesName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPrizesCode() {
        return prizesCode;
    }

    public void setPrizesCode(String prizesCode) {
        this.prizesCode = prizesCode;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getExtendCode() {
        return extendCode;
    }

    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
    }

    @Override
    public String toString() {
        return "PrizesWeightDomain{" +
                "id='" + id + '\'' +
                ", prizesName='" + prizesName + '\'' +
                ", weight=" + weight +
                ", prizesCode='" + prizesCode + '\'' +
                ", num=" + num +
                ", extendCode='" + extendCode + '\'' +
                '}';
    }
}
