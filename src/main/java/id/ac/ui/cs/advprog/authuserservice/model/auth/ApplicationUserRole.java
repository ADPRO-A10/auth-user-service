package id.ac.ui.cs.advprog.authuserservice.model.auth;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static id.ac.ui.cs.advprog.authuserservice.model.auth.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    BUYER(Sets.newHashSet(BUYER_CREATE, BUYER_READ, BUYER_UPDATE, BUYER_DELETE)),
    SELLER(Sets.newHashSet(SELLER_READ, SELLER_CREATE, SELLER_DELETE, SELLER_UPDATE));


    private final Set<ApplicationUserPermission> permissions;


    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> authorities = getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
        return authorities;
    }
}
