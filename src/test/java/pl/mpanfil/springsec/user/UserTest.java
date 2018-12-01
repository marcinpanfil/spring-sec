package pl.mpanfil.springsec.user;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testGetAuthorities() {
        // given
        Authority readA = new Authority(1, "read", null);
        Authority writeA = new Authority(2, "write", null);
        Authority modifyA = new Authority(3, "modify", null);
        Authority grantA = new Authority(4, "grant", null);
        Set<Authority> authoritiesRole1 = Set.of(readA, writeA);
        Set<Authority> authoritiesRole2 = Set.of(modifyA, grantA);
        Role role1 = new Role(1, "user", authoritiesRole1);
        Role role2 = new Role(2, "admin", authoritiesRole2);
        User user = new User(1, "testuser", "pass", Set.of(role1, role2));
        // when
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        // then
        assertEquals(4, authorities.size());
    }

}