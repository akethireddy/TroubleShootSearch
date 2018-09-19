package troubleShootSearch.util;

import java.util.List;

import troubleShootSearch.searchModule.Visitor;

public class Pro1V1 implements ProductVersionI{

    private List<String> troubleShooterlist = null;

    public Pro1V1() {
//        troubleShooterlist = product.getProduct1().getContentList();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public List<String> getTroubleShooterlist() {
        return troubleShooterlist;
    }
    @Override
    public void setTroubleShooterlist(List<String> troubleShooterlist) {
        this.troubleShooterlist = troubleShooterlist;
    }
}
