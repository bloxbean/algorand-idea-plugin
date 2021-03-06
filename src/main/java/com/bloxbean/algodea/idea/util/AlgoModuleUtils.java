package com.bloxbean.algodea.idea.util;

import com.bloxbean.algodea.idea.core.action.util.AlgoContractModuleHelper;
import com.bloxbean.algodea.idea.module.AlgorandModuleType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;
import java.util.Collection;

public class AlgoModuleUtils {

    public static Collection<Module> getAlgorandModules(Project project) {
        return ModuleUtil.getModulesOfType(project, AlgorandModuleType.getInstance());
    }

    public static String getModuleDirPath(Project project) {
        Collection<Module> modules = getAlgorandModules(project);
        if(modules == null || modules.size() == 0)
            return null;

        Module module = modules.iterator().next();
        return ModuleUtil.getModuleDirPath(module);
    }

    public static VirtualFile getFile(Project project, String filePath) {
        return VfsUtil.findFileByIoFile(new File(project.getBasePath() + File.separator + filePath), true);
    }

    //Check relativePath for a source file in module src folder. If not in src folder, then check in generated-src folder
    public static String getRelativePathFromSourceRoot(Project project, VirtualFile srcFile) {

        Module[] modules = ModuleManager.getInstance(project).getModules();

        if(modules != null) {
            for (Module module : modules) {
                VirtualFile[] roots = ModuleRootManager.getInstance(module).getSourceRoots();
                if(roots != null) {
                    for (VirtualFile root : roots) {
                        String relPath = VfsUtil.getRelativePath(srcFile, root, File.separatorChar);
                        if (relPath != null)
                            return relPath;
                    }
                }

                //Check if generated-src folder is there
                VirtualFile genSrcFolder = AlgoContractModuleHelper.getGeneratedSourceFolder(project, module, false);
                if(genSrcFolder != null && genSrcFolder.exists()) {
                    String relPath = VfsUtil.getRelativePath(srcFile, genSrcFolder, File.separatorChar);
                    if (relPath != null)
                        return relPath;
                }
            }
        }

        return null;
    }

    //not used
//    public static VirtualFile getSourceVirtualFileByRelativePath(Project project, String relPath) {
//
//        Module[] modules = ModuleManager.getInstance(project).getModules();
//
//        if (modules != null) {
//            for (Module module : modules) {
//                VirtualFile[] roots = ModuleRootManager.getInstance(module).getSourceRoots();
//                if(roots != null) {
//                    for (VirtualFile root : roots) {
//                        VirtualFile vf = VfsUtil.findRelativeFile(relPath, root);
//                        if(vf != null)
//                            return vf;
//                    }
//                }
//            }
//        }
//
//        return null;
//    }

    public static String getFirstSourceRootPath(Project project) {
        return _getFirstSourceRootPath(project);
    }

    private static String _getFirstSourceRootPath(Project project) {
        if(project == null)
            return null;

        Module[] modules = ModuleManager.getInstance(project).getModules();
        if(modules == null || modules.length == 0)
            return project.getBasePath();

        Module module = modules[0];
        VirtualFile[] roots = ModuleRootManager.getInstance(module).getSourceRoots(false);
        if(roots != null && roots.length > 0) {
            return roots[0].getPath();
        }

        return null;
    }
}
