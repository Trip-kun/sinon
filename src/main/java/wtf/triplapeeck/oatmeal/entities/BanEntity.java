package wtf.triplapeeck.oatmeal.entities;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BanEntity {
    private @NotNull UserEntity user;
    private @NotNull String reason;
    private @NotNull long startTimestamp;
    private @Nullable long endTimestamp;
    private @NotNull boolean active;
    private @NotNull boolean isPermanent;

    public BanEntity(UserEntity user, String reason, long endTimestamp) {
        this.user = user;
        this.reason = reason;
        this.startTimestamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
        this.endTimestamp = endTimestamp;
        this.active = active;
    }

    public BanEntity(UserEntity user, String reason) {
        this.user = user;
        this.reason = reason;
        this.startTimestamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
        this.endTimestamp = endTimestamp;
        this.active = active;
    }

    @NotNull
    public UserEntity getUser() {
        return user;
    }

    @NotNull
    public String getReason() {
        return reason;
    }

    public void setReason(@NotNull String reason) {
        this.reason = reason;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }
}
