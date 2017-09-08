package com.miao.test.controller;

import com.miao.test.dao.CriticismDAO;
import com.miao.test.dao.EmployeeDAO;
import com.miao.test.dao.MessageDAO;
import com.miao.test.dao.ReplyDAO;
import com.miao.test.pojo.Criticism;
import com.miao.test.pojo.Employee;
import com.miao.test.pojo.Message;
import com.miao.test.pojo.Reply;
import com.miao.test.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by 10048 on 2017/9/6.
 */
@Controller
public class MainController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private CriticismDAO criticismDAO;

    @Autowired
    private ReplyDAO replyDAO;

//    @RequestMapping(value = "hello", method = RequestMethod.GET)
//    public String hello() {
//        return "hello";
//    }

    @RequestMapping(value = "/statusRecognise", method = RequestMethod.GET)
    public String test() {
        System.out.println("====================");
        return "statusRecognise";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        List<Message> messages = messageDAO.findMessageByCount(8);      //只显示最新的8条数据
        model.addAttribute("messages", messages);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("eId") String eId, @RequestParam("password") String password, HttpSession session, Model model) {
        Employee employee = employeeDAO.findEmployeeById(Long.parseLong(eId));
        if (employee != null && employee.getPassword().equals(password)) {
            session.setAttribute("employee", employee);

            List<Message> messages = messageDAO.findMessageByCount(8);  //只显示最新的8条数据
            if (messages != null) {
                model.addAttribute("messages", messages);
            }

            return "index";
        }
        return "error";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message(@RequestParam("mId") String mId, Model model) {
        Message message = messageDAO.findMessageById(Long.parseLong(mId));
        if (message != null) {
            model.addAttribute("message", message);
        }

        Criticism criticism = criticismDAO.findCriticismByMsgId(Long.parseLong(mId));
        if (criticism != null) {
            model.addAttribute("criticism", criticism);
        }

        List<Reply> replies = replyDAO.findReplyByMsgId(Long.parseLong(mId));
        if (replies != null) {
            model.addAttribute("replies", replies);
        }

        return "showMsg";
    }

//    @RequestMapping(value = "GetMessageList", method = RequestMethod.GET)
//    public String GetMessageList2(Model model) {
//        List<Message> messageList = messageDAO.findAllMessage();
//        model.addAttribute("messageList", messageList);
//        return "messageList";
//    }

    @RequestMapping(value = "GetMessageList", method = RequestMethod.GET)
    public String getMessageList(@RequestParam("currentPage") int currentPage, Model model) {
        Page page1 = new Page();
        page1.setCurPage(currentPage);
        long count = messageDAO.findAllCount();
        page1.setPageCount((int) count / 12);
        page1.setPerPageRows(12);
        page1.setRowCount((int) count);
        List<Message> messageList = messageDAO.findMessageByPage(currentPage * 12,12);      //当前页从0开始计算
        model.addAttribute("page", page1);
        model.addAttribute("messageList", messageList);
        return "messageList";
    }

    @RequestMapping(value = "publishNewMsg", method = RequestMethod.GET)
    public String publishNewMsg(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee == null) {
            System.out.println("88888888888888888888");
            model.addAttribute("error", "请先进行身份识别");
        }
        return "publishNewMsg";
    }

    @RequestMapping(value = "msgPublish", method = RequestMethod.POST)
    public String MsgPublish(@RequestParam("title") String title, @RequestParam("content") String content, HttpSession session, Model model) {
        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        message.setEmployee((Employee)session.getAttribute("employee"));
        message.setGmtCrete(new Date());
        message.setGmtModified(new Date());
        message.setPublishTime(new Date());
        messageDAO.addMessage(message);
        return "publishNewMsg";
    }

    @RequestMapping(value = "criticismPublish", method = RequestMethod.POST)
    public String  criticismPublish(@RequestParam("content") String content, @RequestParam("mId") String mId, HttpSession session, Model model) {
        Criticism criticism = new Criticism();
        criticism.setContent(content);
        criticism.setEmployee((Employee)session.getAttribute("employee"));
        criticism.setCriticismTime(new Date());
        criticism.setGmtCrete(new Date());
        criticism.setGmtModified(new Date());
        criticism.setMessage(messageDAO.findMessageById(Long.parseLong(mId)));
        System.out.println(criticism);
        criticismDAO.addCriticism(criticism);
        model.addAttribute("criticism", criticism);

        Message message = messageDAO.findMessageById(Long.parseLong(mId));
        model.addAttribute("message", message);

        List<Reply> replies = replyDAO.findReplyByMsgId(Long.parseLong(mId));
        model.addAttribute("replies", replies);

        return "showMsg";
    }

    @RequestMapping(value = "replyPublish", method = RequestMethod.POST)
    public String replyPublish(@RequestParam("content") String content, @RequestParam("mId") String mId, HttpSession session, Model model) {
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setGmtCrete(new Date());
        reply.setGmtModified(new Date());
        reply.setReplyTime(new Date());
        reply.setEmployee((Employee) session.getAttribute("employee"));
        reply.setMessage(messageDAO.findMessageById(Long.parseLong(mId)));
        replyDAO.addReplay(reply);

        List<Reply> replies = replyDAO.findReplyByMsgId(Long.parseLong(mId));
        model.addAttribute("replies", replies);

        Criticism criticism = criticismDAO.findCriticismByMsgId(Long.parseLong(mId));
        model.addAttribute("criticism", criticism);

        Message message = messageDAO.findMessageById(Long.parseLong(mId));
        model.addAttribute("message", message);

        return "showMsg";
    }

    @RequestMapping(value = "replyPublish", method = RequestMethod.GET)
    public String replyPublish(@RequestParam("mId") String mId, HttpSession session, Model model) {
        List<Reply> replies = replyDAO.findReplyByMsgId(Long.parseLong(mId));
        model.addAttribute("replies", replies);

        Criticism criticism = criticismDAO.findCriticismByMsgId(Long.parseLong(mId));
        model.addAttribute("criticism", criticism);

        Message message = messageDAO.findMessageById(Long.parseLong(mId));
        model.addAttribute("message", message);
        return "showMsg";
    }
}
