package controllers.dto;

/**
 * Created by Igor_Kravchenko on 4/18/16.
 */
public class InboundAction {
    private String actionName;
    private String target;

    public InboundAction() {
    }


    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


}
