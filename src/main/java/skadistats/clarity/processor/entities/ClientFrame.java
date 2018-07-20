package skadistats.clarity.processor.entities;

import skadistats.clarity.model.EngineType;

public class ClientFrame {

    private final EntityState[] state;
    private final int tick;

    public ClientFrame(EngineType engineType, int tick) {
        this.tick = tick;
        this.state = new EntityState[1 << engineType.getIndexBits()];
    }

    public void copyFromOtherFrame(ClientFrame otherFrame, int idx, int length) {
        System.arraycopy(otherFrame.state, idx, state, idx, length);
    }

    public EntityState copyState(ClientFrame otherFrame, int idx) {
        state[idx] = otherFrame != null ? otherFrame.state[idx] : null;
        return state[idx];
    }

    public int getTick() {
        return tick;
    }

    public void setState(EntityState entityState, int idx) {
        state[idx] = entityState;
    }

    public EntityState getState(int idx) {
        return state[idx];
    }

    public boolean hasState(int idx) {
        return state[idx] != null;
    }

    public int getSize() {
        return state.length;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClientFrame{");
        sb.append("tick=").append(tick);
        sb.append('}');
        return sb.toString();
    }
}
