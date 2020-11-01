package Main.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 还真不能调用父级的构造函数哈.
 * instanceof 用来检测你归属于该类吗？ 或者你归属于该类的派生类吗？
 * 而通过getClass获取信息是用来== 进行检查是否相等的的严格判断，
 * 不存在再继承方面的考虑.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Son extends Parent {

    protected Integer special;

    public Son(Integer id, String name, Integer special) {
        super(id, name);
        this.special = special;
    }

    /**
     * 自反性(Reflexive): x.equals(x)必须返回true.
     * 对称性(Symmetric): x.equals(y)为true时,y.equals(x)也为true.
     * 传递性(Transitive): 对于任何非null的应用值x,y和z,如果x.equals(y)返回true,并且y.equals(z)也返回true,那么x.equals(z)必须返回true.
     * 一致性(Consistence): 如果多次将对象与另一个对象比较,结果始终相同.只要未修改x和y的应用对象,x.equals(y)连续调用x.equals(y)返回相同的值l.
     * 非null(Non-null): 如果x不是null,y为null,则x.equals(y)必须为false
     * @param otherObject
     * @return
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) return false;
        if (otherObject instanceof Son) {
            Son other = (Son) otherObject;
            if (other.getName() == null || this.getName() == null) {
                return false;
            } else {
                return this.getId().equals(other.getId()) &&
                        this.getName().equals(other.getName()) &&
                        this.getSpecial().equals(other.getSpecial());
            }
        }
        return false;
    }

}
