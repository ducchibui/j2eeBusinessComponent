/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author CBui
 */
public class AuthorHelper {
    Session session = null;

    public AuthorHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

public List<Author> getAuthorNames() {
    List<Author> authorList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Author as at ");
        authorList = (List<Author>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return authorList;
}

}
