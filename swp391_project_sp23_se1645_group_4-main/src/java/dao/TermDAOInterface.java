/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Term;
import java.util.List;


public interface TermDAOInterface {
    // show all term
    public List<Term> ShowTerm();
    // List  5 Term by page
    public List<Term> PagingTerm(int index);

    // View Term by id
    public Term ShowTermByID(int id);

    //*Search Term By termname, class name
    public List<Term> searchTermBysubject(String txtSearch);

    //  *Add a Term
    public void AddTerm(Term term);

    //  *Update a Term
    public void UpdateTerm(Term term);

    // *Delete a Term
    public void deleteTerm(int tid);

    // Get end page
    public int getNumberEndPageTerm();
}
