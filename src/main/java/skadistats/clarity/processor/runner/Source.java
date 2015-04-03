package skadistats.clarity.processor.runner;

import com.google.protobuf.CodedInputStream;

public interface Source {

    enum LoopControlCommand {
        CONTINUE, BREAK, FALLTHROUGH
    }

    CodedInputStream stream();
    boolean isTickBorder(int upcomingTick);
    boolean shouldEmitResetOnFullPacket(int tick, int cisOffset);
    LoopControlCommand doLoopControl(Context ctx, int nextTickWithData);

}
