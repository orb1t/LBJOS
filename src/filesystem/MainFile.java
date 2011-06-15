/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Johannes
 */
public abstract class MainFile {
    
    protected String name;
    protected Directory parent;
    protected String owner;
    protected long lastModifiedTime;
    protected long createdTime;
    
    public MainFile(String name, Directory parent, String owner){
        this.name = name;
        this.parent = parent;
        this.owner = owner;
        this.createdTime = new Date().getTime();
        this.lastModifiedTime = this.createdTime;
        if (parent != null){
            FileSystem.addFile(this);
        }
    }
    
    public abstract boolean isEmpty();
    
    public abstract int size();

    public String getPath() {
        return !isRoot() ? parent.getPath() + "/" + name : name;
    }
    
    protected void setLastModifiedTime(){
        lastModifiedTime = new Date().getTime();
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
        setLastModifiedTime();
    }

    /**
     * @return the parent
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Directory parent) {
        this.parent = parent;
        setLastModifiedTime();
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
        setLastModifiedTime();
    }

    /**
     * @return the lastModifiedTime
     */
    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * @param lastModifiedTime the lastModifiedTime to set
     */
    public void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * @return the createdTime
     */
    public long getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
    
    public boolean isRoot(){
        return parent == null;
    }
    
    public abstract void clear();
    
    public abstract boolean isDirectory();
    
    public abstract MainFile getFile(String filename);
}
