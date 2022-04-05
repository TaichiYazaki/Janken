package com.example.janken.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.example.janken.Form.JankenForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class JankenController {

    @ModelAttribute
    private JankenForm setUpJankenForm() {
        return new JankenForm();
    }

    @RequestMapping("/mainMenu")
    public String mainMenu(JankenForm jankenForm, Model model) {
        jankenForm.setJanken("0");
        return "janken";
    }

    @RequestMapping("/janken1")
    public String janken(JankenForm jankenForm, Model model) {
        /*
         * その１一般的なやり方
         * Random random = new Random();
         * int num=random.nextInt(3);
         * System.out.println(num);
         * System.out.println(jankenForm);
         * int str= Integer.parseInt(jankenForm.getGu());
         * if(str==(num)){
         * System.out.println("あいこ");
         * }
         */

        /**
         * その２ stream APIを利用したrandomで配列から値を取得する方法
         * Idea is to skip an arbitrary number of elements (but not the last one!), then
         * get the first element if it exists.
         */
        List<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 2));
        Random r = new Random();
        int num = nums
                .stream()
                .skip(r.nextInt(nums.size()))
                .findFirst()
                .get();
        String numstr = Integer.toString(num);
        Integer janint = Integer.parseInt(jankenForm.getJanken());

        if (jankenForm.getJanken().isEmpty()) {
            return "redirect:/mainMenu";
        }

        if (jankenForm.getJanken().equals(numstr)) {
            model.addAttribute("resultMsg", "結果：あいこ");
        } else if (janint < num) {
            model.addAttribute("jankenCount1", "1連勝中!!");
            model.addAttribute("resultMsg", "結果：勝ち!!!");
            return "janken2";
        } else {
            model.addAttribute("resultMsg", "結果：負け・・・");
        }
        return "forward:/mainMenu";

    }

    @RequestMapping("/janken2")
    public String janken2(JankenForm jankenForm, Model model) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 2));
        Random r = new Random();
        int num = nums
                .stream()
                .skip(r.nextInt(nums.size()))
                .findFirst()
                .get();
        String numstr = Integer.toString(num);
        Integer janint = Integer.parseInt(jankenForm.getJanken());

        if (jankenForm.getJanken().equals(numstr)) {
            model.addAttribute("resultMsg", "結果：あいこ");
        } else if (janint < num) {
            model.addAttribute("jankenCount2", "2連勝中!!");
            model.addAttribute("resultMsg", "結果：勝ち!!!");
            return "janken3";
        } else {
            model.addAttribute("resultMsg", "結果：負け・・・");
        }
        return "forward:/mainMenu";
    }

    @RequestMapping("/final")
    public String janken3(JankenForm jankenForm, Model model) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 2));
        Random r = new Random();
        int num = nums
                .stream()
                .skip(r.nextInt(nums.size()))
                .findFirst()
                .get();
        String numstr = Integer.toString(num);
        Integer janint = Integer.parseInt(jankenForm.getJanken());

        if (jankenForm.getJanken().equals(numstr)) {
            model.addAttribute("resultMsg", "結果：あいこ");
        } else if (janint < num) {
            model.addAttribute("final", "3連勝おめでとう!!");
            model.addAttribute("resultMsg", "結果：勝ち!!!");
            return "final";
        } else {
            model.addAttribute("resultMsg", "結果：負け・・・");
        }
        return "forward:/mainMenu";

    }
}
