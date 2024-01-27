package net.yesman.scpff.server.entity.init;

import java.util.ArrayList;
import java.util.List;

public class EntityInit {
    public static final List<String> VOICE_LINES = new ArrayList<>();

    public static void init() {
        add049VoiceLine("Do not be afraid, I have the cure.");
        add049VoiceLine("I am only trying to help you.");
        add049VoiceLine("Do not resist, for I have the cure");
    }
    private static void add049VoiceLine(String voiceLine) {
        VOICE_LINES.add(voiceLine);
    }

}
