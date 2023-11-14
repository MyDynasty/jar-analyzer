package me.n1ar4.jar.analyzer.gui.vul;

import me.n1ar4.jar.analyzer.engine.CoreHelper;
import me.n1ar4.jar.analyzer.gui.MainForm;

public class ProcessBuilderAction {
    public static void register() {
        MainForm instance = MainForm.getInstance();

        instance.getProcessBuilderStartButton().addActionListener(e -> {
            if (MainForm.getEngine() == null) {
                return;
            }

            String className = "java/lang/ProcessBuilder";
            String methodName = "start";
            String methodDesc = "()Ljava/lang/Process;";

            new Thread(() -> CoreHelper.refreshCallSearch(
                    className, methodName, methodDesc)).start();

            MainForm.getInstance().getTabbedPanel().setSelectedIndex(1);
        });
    }
}
