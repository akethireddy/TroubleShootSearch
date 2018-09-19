package troubleShootSearch.util;

import troubleShootSearch.searchModule.Visitor;

import java.util.List;

public interface ProductVersionI {
    void accept(Visitor visitor);
    void setTroubleShooterlist(List<String> troubleShooterlist);
}
