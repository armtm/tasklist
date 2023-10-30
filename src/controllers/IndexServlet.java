package controllers;

//一覧表示するコントローラー

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        //①Task.java(modelクラス、エンティティクラス）をオブジェクト化
        EntityManager em = DBUtil.createEntityManager();

        //②createNamedQueryメソッドの引数に、エンティティクラスで命名したgetALLTasksを指定し
        //データベースへ問い合わせる
        //③問い合わせ結果をリスト形式で取得（getResultList() メソッド）
        List<Task> tasks = em.createNamedQuery("getAllTasks", Task.class).getResultList();
        response.getWriter().append(Integer.valueOf(tasks.size()).toString());

        em.close();
    }

}
