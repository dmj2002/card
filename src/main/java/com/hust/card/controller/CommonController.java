package com.hust.card.controller;

import com.hust.card.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("/api/capturePicture")
    public Result<?> capturePicture() {
        return null;
    }

    @PostMapping("/api/geometricCorrection")
    public Result<?> geometricCorrection() {
        return null;
    }

    @PostMapping("/api/segement/init")
    public Result<?> initSegement() {
        return null;
    }

    @PostMapping("/api/segement/point")
    public Result<?> pointSegement() {
        return null;
    }

    @PostMapping("/api/segement/box")
    public Result<?> boxSegement() {
        return null;
    }
}
