package id.ac.ui.cs.advprog.authuserservice.model.auth;

public enum ApplicationUserPermission {
    BUYER_CREATE("buyer:create"),
    BUYER_READ("buyer:read"),
    BUYER_UPDATE("buyer:update"),
    BUYER_DELETE("buyer:delete"),
    SELLER_CREATE("seller:create"),
    SELLER_READ("seller:read"),
    SELLER_UPDATE("seller:update"),
    SELLER_DELETE("seller:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
