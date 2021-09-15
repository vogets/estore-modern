package com.estore.admin.user;

import com.estore.common.entity.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateRole()
    {
        Role roleAdmin=new Role();
        roleAdmin.setDescription("Manage Everything");
        roleAdmin.setName("Admin");
        Role savedRole=roleRepository.save(roleAdmin);
        Assert.assertEquals(savedRole.getName(),"Admin");
    }

    @Test
    public void testCreateAllRoles()
    {
        System.out.println("Salesperson");
        Role salesPerson=new Role("Salesperson","manage product price,customers,shipping,orders and sales report");
        System.out.println("Editor");
        Role roleEditor=new Role("Editor",
                "manage categories ,brands,products,articles and menus");
        System.out.println("Shipper");
        Role roleShipper=new Role("Shipper",
                "view products,view orders and update order status");
        System.out.println("Assistant");
        Role roleAssistant=new Role("Assistant",
                "manage questions and reviews");
        List<Role> roleList=new ArrayList<Role>();
        roleList.add(salesPerson);
        roleList.add(roleEditor);
        roleList.add(roleShipper);
        roleList.add(roleAssistant);
        roleRepository.saveAll(roleList);

    }
}
