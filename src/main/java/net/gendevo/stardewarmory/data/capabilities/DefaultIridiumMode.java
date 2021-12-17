package net.gendevo.stardewarmory.data.capabilities;

public class DefaultIridiumMode implements IIridiumMode {
    private boolean isOn;

    @Override
    public void setIridiumMode(boolean iridium) {
        this.isOn = iridium;
    }

    @Override
    public boolean isIridiumMode() {
        return isOn;
    }
}
