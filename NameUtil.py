import os

def process_filenames(folder_path):
    # 获取文件夹中的所有文件名
    filenames = os.listdir(folder_path)

    for filename in filenames:
        # 检查文件名是否符合指定格式
        if filename.endswith("删除"):
            # 提取文件名中的部分
            new_filename = filename[:-2]  # 删除最后一个单词和最后的句号
            # 构建新的文件路径
            old_path = os.path.join(folder_path, filename)
            new_path = os.path.join(folder_path, new_filename)

            # 重命名文件
            os.rename(old_path, new_path)
            print(f"重命名文件：{filename} -> {new_filename}")

def main():
    # 指定要处理的文件夹路径
    folder_path = "E:\BD NetDisk\汉堡王kyokyo"

    # 调用函数处理文件名
    process_filenames(folder_path)

if __name__ == "__main__":
    main()