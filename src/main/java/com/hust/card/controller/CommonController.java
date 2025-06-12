package com.hust.card.controller;

import com.hust.card.common.result.Result;
import com.hust.card.common.util.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.*;

@Slf4j
@RestController
public class CommonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    @Value("${dir.base}")
    private String basedir;
    @GetMapping("/api/capturePicture")
    public Result<?> capturePicture(@RequestParam("ip") String ip,
                                    @RequestParam(value = "username",required = false,defaultValue = "admin") String username,
                                    @RequestParam(value = "password",required = false,defaultValue = "123456") String password) {
        Process process = null;
        try {
            // 准备命令
            String taskLabel = UUID.randomUUID().toString();
            File taskDir = new File(basedir + "/task_logs/" + taskLabel);
            if (!taskDir.exists()) {
                if (!taskDir.mkdirs()) {
                    throw new RuntimeException("创建任务目录失败");
                }
            }
            List<String> command = new ArrayList<>();
            command.add(String.format("CapturePictures.exe"));
            command.add(String.format(ip));
            command.add(String.format(username));
            command.add(String.format(password));
            command.add(String.format(basedir + "/task_logs/" + taskLabel + "/visible.jpg"));
            command.add(String.format(basedir + "/task_logs/" + taskLabel + "/thermal.jpg"));
            command.add(String.format(basedir + "/task_logs/" + taskLabel + "/data.csv"));
            // 执行命令
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File(basedir + "/capturePictures"));
            processBuilder.command(command);
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
//            StringBuilder outputString = null;
//            //获取输入流
//            InputStream inputStream = process.getInputStream();
//            //转成字符输入流
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//            int len = -1;
//            char[] c = new char[2048];
//            outputString = new StringBuilder();
//            //读取进程输入流中的内容
//            while ((len = inputStreamReader.read(c)) != -1) {
//                String s = new String(c, 0, len);
//                outputString.append(s);
//            }
//            LOGGER.debug("算法执行结果：{}", outputString);
//            inputStream.close();
//            inputStreamReader.close();
            // 等待进程完成
            process.waitFor();
            int exitValue = process.exitValue();
            LOGGER.info("进程结束，退出码：{}", exitValue);
            if( exitValue != 0) {
                return Result.error("捕获图片失败，退出码：" + exitValue);
            }
            Map<String, Object> result = new HashMap<>();
            result.put("taskLabel", taskLabel);
            result.put("visiblePic", Base64Util.convertToBase64(basedir + "/task_logs/" + taskLabel + "/visible.jpg"));
            result.put("thermalPic", Base64Util.convertToBase64(basedir + "/task_logs/" + taskLabel + "/thermal.jpg"));
            return Result.OK(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("捕获图片失败");
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
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
