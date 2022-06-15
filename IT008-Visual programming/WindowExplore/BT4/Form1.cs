using Microsoft.VisualBasic.FileIO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Management;
using System.Diagnostics;

namespace BT4
{
    public partial class Form1 : Form
    {        
        public Form1()
        {
            InitializeComponent();
            timer1.Start();
            
        }
        //
        #region static variable
        //For count number file & folder of selected node
        private int iFolder;
        private int iFile;
        //2 stack for up, back and forward function 
        private Stack<string> path_stack = new Stack<string>();
        private Stack<string> path_stack2 = new Stack<string>();    
        //Flags for cut, copy and paste function
        private bool IsCopying = false;
        private bool IsCutting = false;
        private bool IsFolder = false;
        private bool IsListView = false; 
        //Temp variable
        private ListViewItem itemPaste;
        private string path_Folder; 
        private string path_File;
        private string path_Source;
        private string path_Destination;
        #endregion
        //
        #region Event list view
        //
        private void AddListView(TreeNode root)
        {
            
            string fullpath = root.FullPath;
            string selected_node_path = CreatPath(fullpath);
            //Before you add new list view, you must clear previous list view
            listView1.Items.Clear();
            //Get list infomation of folder at selected_node_path -> Add list view
            DirectoryInfo[] subfolder_info = new DirectoryInfo(selected_node_path).GetDirectories();
            AddFolderListView(subfolder_info);
            //Get list infomation of file at selected_node_path -> Add list view
            FileInfo[] subfile_info = new DirectoryInfo(selected_node_path).GetFiles();
            AddFileListView(subfile_info);
        }
        //
        private int IconListView(string s)
        {
            //Sorry about this
            if (s == ".png") return 4;
            if (s == ".ppt" || s == ".pptx") return 3;
            if (s == ".doc" || s == ".docx" | s == ".txt") return 5;
            if (s == ".rar" || s == ".zip") return 6;
            if (s == ".mp3") return 2;
            return 1;
        }
        //
        private void AddFileListView(FileInfo[] subfile_info)
        {
            iFile = 0;
            foreach (var file in subfile_info)
            {
                //An item have 5 column: name | type | size | date modify | full path
                string[] value = new string[5];
                value[0] = file.Name.ToString();
                value[1] = file.Extension;
                value[2] = (file.Length / 1024).ToString();
                value[3] = file.LastWriteTime.ToString();
                value[4] = file.FullName.ToString();
                ListViewItem item1 = new ListViewItem(value);
                item1.ImageIndex = IconListView(value[1]);
                iFile++;
                listView1.Items.Add(item1);
            }
        }
        //
        private void AddFolderListView(DirectoryInfo[] subfolder_info)
        {
            iFolder = 0;
            //An item have 5 column: name | type | size | date modify | full path
            foreach (var item in subfolder_info)
            {
                string[] value = new string[5];
                value[0] = item.Name.ToString();
                value[1] = "Folder";
                value[2] = "N/A";
                value[3] = item.LastWriteTime.ToString();
                value[4] = item.FullName.ToString();
                ListViewItem item1 = new ListViewItem(value);
                item1.ImageIndex = 0;
                iFolder++;
                listView1.Items.Add(item1);

            }
        }
        //Event double click an item in listview
        private void listView1_MouseDoubleClick(object sender, MouseEventArgs e) 
        {
            try
            {
                ListViewItem item = listView1.FocusedItem;
                //Get full path of focused item
                string path = item.SubItems[4].Text;
                FileInfo inf = new FileInfo(path);
                //Run file, you don't need to know what type of file
                if (inf.Exists)
                {
                    Process.Start(path);
                    return;
                }
                //Open folder, you just plus folder name into current path
                DirectoryInfo inf2 = new DirectoryInfo(path + "\\");
                if (inf2.Exists)
                {
                    txt_path.Text = path + "\\";
                    path_stack.Push(txt_path.Text);
                    listView1.Items.Clear();
                    DirectoryInfo[] subfolder_info = new DirectoryInfo(path).GetDirectories();
                    AddFolderListView(subfolder_info);
                    FileInfo[] subfile_info = new DirectoryInfo(path).GetFiles();
                    AddFileListView(subfile_info);
                    status_bar.Text = iFolder + " Folder(s) " + iFile + " File(s)";

                }
                else
                {
                    Message ms = new Message("Folder not found");
                    ms.Show();
                }
            }
            catch (Exception) {
                Message ms = new Message("Acces Denied" + Environment.NewLine + "Please run as adminstrator");
                ms.Show();
            }

        }
        //Event enter an item in listview, it have same event double click
        private void listView1_KeyPress(object sender, KeyPressEventArgs e)
        {
            try
            {
                ListViewItem item = listView1.FocusedItem;
                string path = item.SubItems[4].Text;
                FileInfo inf = new FileInfo(path);
                if (inf.Exists)
                {
                    Process.Start(path);
                    return;
                }
                DirectoryInfo inf2 = new DirectoryInfo(path + "\\");
                if (inf2.Exists)
                {
                    txt_path.Text = path + "\\";
                    path_stack.Push(txt_path.Text);
                    listView1.Items.Clear();
                    DirectoryInfo[] subfolder_info = new DirectoryInfo(path).GetDirectories();
                    AddFolderListView(subfolder_info);
                    FileInfo[] subfile_info = new DirectoryInfo(path).GetFiles();
                    AddFileListView(subfile_info);
                    status_bar.Text = iFolder + " Folder(s) " + iFile + " File(s)";
                }
                else
                {
                    Message ms = new Message("Folder not found");
                    ms.Show();
                }
            }
            catch (Exception) {
                Message ms = new Message("Acces Denied" + Environment.NewLine + "Please run as adminstrator");
                ms.Show();
            }

        }
        //
        #endregion
        //
        #region Event tree view
        //
        private void AddTreeView(TreeNode root)
        {
            string selected_node_path = "";
            string fullpath = root.FullPath;
            selected_node_path = CreatPath(fullpath);
            if (Directory.Exists(selected_node_path))
            {
                string[] sub_folder_path = Directory.GetDirectories(selected_node_path);
                root.Nodes.Clear();
                //Any path like that: "C:\Users\..., so you must split path and save node_name
                foreach (var folder in sub_folder_path)
                {
                    string[] ss = folder.Split('\\');
                    TreeNode subnode = new TreeNode(ss[ss.Length - 1]);
                    root.Nodes.Add(subnode);
                }
            }
            root.Expand();
        }
        //
        private int IconTreeView(string s)
        {
            int tmp = 1;
            if (s == "3") tmp = 2;
            if (s == "4") tmp = 1;
            if (s == "5") tmp = 3;
            return tmp;
        }
        //Event click any node on tree view
        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            try
            {                
                TreeNode selected_node = e.Node;              
                string selected_node_path = "";
                string fullpath = selected_node.FullPath;
                selected_node_path = CreatPath(fullpath);
                //Add path to stack
                path_stack.Push(selected_node_path);   
                //Display on screen
                txt_path.Text = selected_node_path;
                if (Directory.Exists(selected_node_path))
                {
                    string[] sub_folder = Directory.GetDirectories(selected_node_path);
                    selected_node.Nodes.Clear();
                    foreach (var folder in sub_folder)
                    {
                        string[] split_folder = folder.Split('\\');
                        TreeNode node = new TreeNode(split_folder[split_folder.Length - 1]);
                        selected_node.Nodes.Add(node);

                    }
                    selected_node.Expand();
                    //Update list view
                    listView1.Items.Clear();
                    DirectoryInfo[] sub_folder_info = new DirectoryInfo(selected_node_path).GetDirectories();
                    AddFolderListView(sub_folder_info);                   
                    FileInfo[] sub_file_info = new DirectoryInfo(selected_node_path).GetFiles();
                    AddFileListView(sub_file_info);
                    //Update status bar
                    status_bar.Text = iFolder + " Folder(s) " + iFile + " File(s)";
                    
                }

            }
            catch (Exception)
            {
                
            }
        }
        //
        #endregion
        //
        #region toolstrip
        //
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DialogResult dlr = MessageBox.Show("Do you want to exit ?", "Message", MessageBoxButtons.YesNo);
            if (dlr == DialogResult.Yes) Application.Exit();

        }
        //
        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            About_me fr = new About_me();
            fr.ShowDialog();
        }
        //Delete function
        private void deleteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                //Count number item to check list view
                if (listView1.SelectedItems.Count > 0)
                {                   
                    // Creat main path to main node in tree view
                    string selected_node_path = listView1.SelectedItems[0].SubItems[4].Text;
                    //Check path type and delete it ... what an angry action !
                    if (listView1.SelectedItems[0].SubItems[1].Text.CompareTo("Folder") == 0)
                    {
                        if (Directory.Exists(selected_node_path))
                        {                           
                            Directory.Delete(selected_node_path, true);
                        }
                    }
                    else
                    {
                        if (File.Exists(selected_node_path))
                        {
                            File.Delete(selected_node_path);
                        }
                    }
                    //Update listview
                    listView1.Items.Remove(listView1.Items[0]);
                }
                item_refresh.PerformClick();
            }
            catch (Exception)
            {
                Message ms = new Message("Acces Denied" + Environment.NewLine + "Please run as adminstrator");
                ms.Show();

            }
        }
        //Ename function
        private void renameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            listView1.SelectedItems[0].BeginEdit();
        }
        //
        #endregion
        //
        #region Event button
        //Event enter path
        private void btn_Go_Click(object sender, EventArgs e)
        {
            try
            {
                if (txt_path.Text != "")
                {
                    FileInfo inf = new FileInfo(txt_path.Text.Trim());
                    //Check path type
                    if (inf.Exists)
                    {
                        System.Diagnostics.Process.Start(txt_path.Text.Trim());
                        DirectoryInfo parent = inf.Directory;
                        txt_path.Text = parent.FullName;
                        return;

                    }
                    else
                    {
                        //Update list view
                        listView1.Items.Clear();
                        DirectoryInfo[] subfolder_info = new DirectoryInfo(txt_path.ToString()).GetDirectories();
                        AddFolderListView(subfolder_info);
                        FileInfo[] subfile_info = new DirectoryInfo(txt_path.ToString()).GetFiles();
                        AddFileListView(subfile_info);
                    }
                }

            }
            catch (Exception)
            {
                Message ms = new Message("Path not found");
                ms.Show();
            }

        }
        //Cut function
        private void btn_cut_Click(object sender, EventArgs e)
        {            
            IsCutting = true;
            if (listView1.Focused)
            {
                IsListView = true;
                itemPaste = listView1.FocusedItem;
                itemPaste.ForeColor = Color.Gray;
                if (itemPaste == null) return;
                //Check cutting type: file or folder
                if (itemPaste.SubItems[1].Text.Trim() == "Folder")
                {
                    IsFolder = true;
                    path_Folder = itemPaste.SubItems[4].Text + "\\";
                }
                else
                {
                    IsFolder = false;
                    path_File = itemPaste.SubItems[4].Text;
                }
            }
          
            btn_paste.Enabled = true;
            item_paste.Enabled = true;
            ct_paste.Enabled = true;
        }
        //Copy function, like as cut
        private void btn_copy_Click(object sender, EventArgs e)
        {
            IsCopying = true;
            if (listView1.Focused)
            {
                IsListView = true;
                itemPaste = listView1.FocusedItem;
                if (itemPaste == null) return;
                //Check copying type: file or folder

                if (itemPaste.SubItems[1].Text.Trim() == "Folder")
                {
                    IsFolder = true;
                    path_Folder = itemPaste.SubItems[4].Text + "\\";
                }
                else
                {
                    IsFolder = false;
                    path_File = itemPaste.SubItems[4].Text;
                }
            }           
            btn_paste.Enabled = true;
            item_paste.Enabled = true;
            ct_paste.Enabled = true;
        }
        //Paste function
        private void btn_paste_Click(object sender, EventArgs e)
        {        
            try
            {   
                //Because of laziness, I have code paste function for list view
                if (IsListView)
                {
                    //Check pasting type: file or folder
                    if (IsFolder)
                    {
                        path_Source = path_Folder;
                        path_Destination = txt_path.Text.Substring(0, txt_path.Text.Length-1) + "\\" +  itemPaste.SubItems[0].Text;
                    }
                    else
                    {
                        path_Source = path_File;
                        path_Destination = txt_path.Text.Substring(0, txt_path.Text.Length - 1) + "\\" + itemPaste.SubItems[0].Text;
                    }
                }
                //Check pasting type: copy or cut

                if (IsCopying)
                {
                    if (IsFolder)
                    {
                        FileSystem.CopyDirectory(path_Source, path_Destination);
                    }
                    else
                    {
                        FileSystem.CopyFile(path_Source, path_Destination);
                    }
                    IsCopying = false;
                }
                if (IsCutting)
                {
                    if (IsFolder)
                    {
                        FileSystem.MoveDirectory(path_Source, path_Destination);
                    }
                    else
                    {
                        FileSystem.MoveFile(path_Source, path_Destination);
                    }
                    IsCutting = false;
                }
                btn_paste.Enabled = false;
                item_paste.Enabled = false;
                ct_paste.Enabled = false;
                item_refresh_Click(sender, e);
            }
            catch (Exception) {
                Message ms = new Message("Acces Denied" + Environment.NewLine + "Please run as adminstrator");
                ms.Show();
            }
        }
        //Event refresh, you can make this simply that mean enter current path and go it again
        private void item_refresh_Click(object sender, EventArgs e)
        {
            btn_Go.PerformClick();           
        }
        //Event back & forward to previous path, because user can back many time, you can't use a temp variable like path_pre
        //I think a good selection that is use 2 stack: one for back and one for forward  
        private void btn_back_Click(object sender, EventArgs e)
        {
            try
            {
                path_stack2.Push(path_stack.Peek());
                path_stack.Pop();
                txt_path.Text = path_stack.Peek();
                btn_Go_Click(sender, e);
            }
            catch (Exception) { }
        }
        //
        private void btn_forward_Click(object sender, EventArgs e)
        {
            try
            {
                path_stack.Push(path_stack2.Pop());
                txt_path.Text = path_stack.Peek();
                btn_Go_Click(sender, e);
            }
            catch (Exception) { }
        }
        //Event up, help you back to parent folder, i update a new path and go it for this function
        //Current path will be push into stack 2
        private void btn_up_Click(object sender, EventArgs e)
        {
            try
            {
                if (txt_path.Text != "")
                {
                    string[] sub_path = txt_path.Text.ToString().Split('\\');

                    txt_path.Text = "";
                    for (int i = 0; i < sub_path.Length - 2; i++)
                    {
                        txt_path.Text += sub_path[i] + "\\";
                    }
                }
                path_stack.Push(txt_path.Text);
                btn_Go_Click(sender, e);

            }
            catch (Exception) { }
        }
        //
        #endregion
        //
        #region other function
        //Hack tip help me remove 'my computer' in current path 
        private string CreatPath(string fullpath)
        {
            string selected_node_path = "";
            string[] sub_path = fullpath.Split('\\');
            selected_node_path += sub_path[1];
            for (int i = 2; i < sub_path.Length; i++)
            {
                selected_node_path += sub_path[i] + "\\";
            }

            return selected_node_path;
        }
        //
        private void Form1_Load(object sender, EventArgs e)
        {
            txt_path.Width = this.Width - 100;
            //Clear all node
            if (treeView1 != null)
            {
                treeView1.Nodes.Clear();
            }
            //Add root node
            TreeNode root_node = new TreeNode("My Computer", 4, 4);
            this.treeView1.Nodes.Add(root_node);
            //Add node
            //List disk
            ManagementObjectSearcher query = new ManagementObjectSearcher("Select * from Win32_LogicalDisk");
            ManagementObjectCollection col = query.Get();
            //Create node and add to root node
            foreach (var disk in col)
            {
                TreeNode disk_node = new TreeNode(disk.GetPropertyValue("Name").ToString() + "\\",
                    IconTreeView((disk["DriveType"].ToString())), IconTreeView((disk["DriveType"].ToString())));
                root_node.Nodes.Add(disk_node);
            }
            //Show node_children

            root_node.Expand();
        }
        //
        private void timer1_Tick(object sender, EventArgs e)
        {
            lblTime.Text = (DateTime.Now.Hour < 10 ? "0" + DateTime.Now.Hour.ToString() : DateTime.Now.Hour.ToString())
                + ":" + (DateTime.Now.Minute < 10 ? "0" + DateTime.Now.Minute.ToString() : DateTime.Now.Minute.ToString()) 
                + ":" + (DateTime.Now.Second < 10 ? "0" + DateTime.Now.Second.ToString() : DateTime.Now.Second.ToString()) 
                + " " + DateTime.Now.DayOfWeek.ToString() + ", " + (DateTime.Now.Day < 10 ? "0" 
                + DateTime.Now.Day.ToString() : DateTime.Now.Day.ToString()) + "/" + (DateTime.Now.Month < 10 ? "0" 
                + DateTime.Now.Month.ToString() : DateTime.Now.Month.ToString()) + "/" + DateTime.Now.Year;
            if (listView1.Items.Count == 0)
            {
                background.Visible = true;
            }
            else
            {
                background.Visible = false;
            }
             
            if (txt_path.Text != "")
            {
                btn_up.Enabled = true;
            }
            else
            {
                btn_up.Enabled = false;
            }
            if (path_stack.Count != 0)
            {
                btn_back.Enabled = true;
            }
            else
            {
                btn_back.Enabled = false;
            }
            if (path_stack2.Count != 0)
            {
                btn_forward.Enabled = true;
            }
            else
            {
                btn_forward.Enabled = false;
            }
            if (listView1.Focused == true)
            {
                ct_open.Enabled = true;
            }
            else
            {
                ct_open.Enabled = false;
            }
        }      
        //Event enter textbox path
        private void txt_path_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == 13) btn_Go.PerformClick();
        }
        //View function, i can do that, but i don't have enough time
        private void item_view_Click_1(object sender, EventArgs e)
        {
            Message ms = new Message("This function is not supported now");
            ms.Show();
        }
        //Event right click an item and select open
        private void ct_open_Click(object sender, EventArgs e)
        {
            try
            {
                ListViewItem item = listView1.FocusedItem;
                string path = item.SubItems[4].Text;
                FileInfo inf = new FileInfo(path);
                if (inf.Exists)
                {
                    Process.Start(path);
                    return;
                }
                DirectoryInfo inf2 = new DirectoryInfo(path + "\\");

                if (inf2.Exists)
                {
                    txt_path.Text = path + "\\";
                    path_stack.Push(txt_path.Text);
                    listView1.Items.Clear();
                    DirectoryInfo[] subfolder_info = new DirectoryInfo(path).GetDirectories();
                    AddFolderListView(subfolder_info);
                    FileInfo[] subfile_info = new DirectoryInfo(path).GetFiles();
                    AddFileListView(subfile_info);
                }
                else
                {

                }
            }
            catch (Exception) { }
        }
        //Event rename item
        private void listView1_AfterLabelEdit(object sender, LabelEditEventArgs e)
        {
            try
            {
                ListViewItem item = listView1.FocusedItem;
                string path = item.SubItems[4].Text;
                if (e.Label == null) return;
                FileInfo fi = new FileInfo(path);
                if (fi.Exists)
                {
                    FileSystem.RenameFile(path, e.Label + item.SubItems[1].Text);
                    item_refresh_Click(sender, e);

                }
                else
                {
                    FileSystem.RenameDirectory(path, e.Label);
                    item_refresh_Click(sender, e);
                    e.CancelEdit = true;


                }

                item_refresh.PerformClick();
               
            }
            catch(IOException)
            {
                //MessageBox.Show("Acces Denied");
            }
            catch(Exception)
            {

            }
        }
        //Update lbl count selected item(s) in status bar
        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                lbl_selected.Text = listView1.SelectedItems.Count + " item(s) selected";

            }
            else
            {
                lbl_selected.Text = "";

            }


        }
        //
        #endregion
        //
    }
}