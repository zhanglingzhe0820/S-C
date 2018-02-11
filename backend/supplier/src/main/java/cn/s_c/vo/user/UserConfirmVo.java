package cn.s_c.vo.user;

public class UserConfirmVo {
    private boolean isAuthened;
    private boolean isStudent;

    public UserConfirmVo(boolean isAuthened, boolean isStudent) {
        this.isAuthened = isAuthened;
        this.isStudent = isStudent;
    }

    public boolean isAuthened() {
        return isAuthened;
    }

    public void setAuthened(boolean authened) {
        isAuthened = authened;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }
}
