package com.example.boardproject.controller;

import com.example.boardproject.dto.MemberForm;
import com.example.boardproject.entity.Member;
import com.example.boardproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMemberForm() {
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createMember(MemberForm form) {
        log.info(form.toString());
        Member member = form.toEntity();
        Member saved = memberRepository.save(member);
        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        List<Member> memberList = (List<Member>) memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "members/index";
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        Member target = memberRepository.findById(id).orElse(null);
        if (target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제되었습니다.");
        }
        return "redirect:/members";
    }
}
