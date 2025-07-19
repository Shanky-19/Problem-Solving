class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        int n = folder.length;
        String currentFolder = folder[0];
        List<String> ans = new ArrayList<>();
        for(int i=1;i<n;i++) {
            if(folder[i].startsWith(currentFolder+"/")) {
                continue;
            } else {
                ans.add(currentFolder);
                currentFolder = folder[i];
            }
        }
        ans.add(currentFolder);
        return ans;
    }
}