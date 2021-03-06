USE [master]
GO
/****** Object:  Database [OnlineQuiz]    Script Date: 3/14/2020 5:13:51 PM ******/
CREATE DATABASE [OnlineQuiz]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OnlineQuiz', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER01\MSSQL\DATA\OnlineQuiz.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'OnlineQuiz_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER01\MSSQL\DATA\OnlineQuiz_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [OnlineQuiz] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnlineQuiz].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ARITHABORT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OnlineQuiz] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OnlineQuiz] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OnlineQuiz] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OnlineQuiz] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OnlineQuiz] SET  ENABLE_BROKER 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OnlineQuiz] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OnlineQuiz] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OnlineQuiz] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OnlineQuiz] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OnlineQuiz] SET RECOVERY FULL 
GO
ALTER DATABASE [OnlineQuiz] SET  MULTI_USER 
GO
ALTER DATABASE [OnlineQuiz] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OnlineQuiz] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OnlineQuiz] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OnlineQuiz] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [OnlineQuiz] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'OnlineQuiz', N'ON'
GO
ALTER DATABASE [OnlineQuiz] SET QUERY_STORE = OFF
GO
USE [OnlineQuiz]
GO
/****** Object:  Table [dbo].[question]    Script Date: 3/14/2020 5:13:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[q_name] [varchar](100) NOT NULL,
	[date_created] [varchar](11) NULL,
	[ans_1] [varchar](100) NULL,
	[ans_2] [varchar](100) NULL,
	[ans_3] [varchar](100) NULL,
	[ans_4] [varchar](100) NULL,
	[true_answer] [varchar](100) NOT NULL,
	[created_by] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[result]    Script Date: 3/14/2020 5:13:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[result](
	[username] [varchar](50) NULL,
	[score] [float] NULL,
	[numberQuestion] [int] NULL,
	[date_take] [varchar](10) NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_result] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 3/14/2020 5:13:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[role] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[question] ON 

INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (1, N'1 + 1 = ?', N'Feb 27 2020', N'1', N'2', N'3', N'4', N'2', N'teacher1')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (2, N'1 + 2 = ?', N'Feb 27 2020', N'1', N'2', N'3', N'4', N'3', N'teacher0')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (3, N'1 + 3 = ?', N'Feb 27 2020', N'1', N'2', N'3', N'4', N'4', N'teacher1')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (4, N'1 + 4 = ?', N'Feb 27 2020', N'1', N'5', N'3', N'4', N'2', N'teacher1')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (5, N'1 + 5 = ?', N'Feb 27 2020', N'1', N'2', N'6', N'4', N'3', N'teacher0')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (6, N'1 + 6 = ?', N'Feb 27 2020', N'7', N'2', N'3', N'4', N'1', N'teacher1')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (7, N'1 + 7 = ?', N'Feb 27 2020', N'1', N'2', N'3', N'8', N'4', N'teacher1')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (8, N'1 + 8 = ?', N'Feb 27 2020', N'1', N'9', N'3', N'4', N'2', N'teacher0')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (9, N'1 + 9 = ?', N'Feb 27 2020', N'1', N'10', N'13', N'4', N'2', N'teacher0')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (10, N'1 + 10 = ?', N'Feb 27 2020', N'1', N'2', N'11', N'4', N'3', N'teacher0')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (11, N'1 + 11 = ?', N'Feb 27 2020', N'12', N'2', N'3', N'4', N'1', N'teacher1')
INSERT [dbo].[question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (12, N'1 + 12 = ?', N'Feb 27 2020', N'1', N'2', N'3', N'13', N'4', N'teacher0')
SET IDENTITY_INSERT [dbo].[question] OFF
INSERT [dbo].[user] ([username], [password], [email], [role]) VALUES (N'teacher0', N'202cb962ac59075b964b07152d234b70', N'teacher0@gmail.com', 0)
INSERT [dbo].[user] ([username], [password], [email], [role]) VALUES (N'teacher1', N'202cb962ac59075b964b07152d234b70', N'fdsadf@fpt.edu.vn', 0)
INSERT [dbo].[user] ([username], [password], [email], [role]) VALUES (N'teacher3', N'202cb962ac59075b964b07152d234b70', N'fdsadf@fpt.edu.vn', 1)
INSERT [dbo].[user] ([username], [password], [email], [role]) VALUES (N'user0', N'202cb962ac59075b964b07152d234b70', N'teacher0@gmail.com', 1)
INSERT [dbo].[user] ([username], [password], [email], [role]) VALUES (N'user1', N'202cb962ac59075b964b07152d234b70', N'fdsadf@fpt.edu.vn', 1)
ALTER TABLE [dbo].[question] ADD  DEFAULT (getdate()) FOR [date_created]
GO
ALTER TABLE [dbo].[result] ADD  CONSTRAINT [DF__result__date_tak__3B75D760]  DEFAULT (getdate()) FOR [date_take]
GO
USE [master]
GO
ALTER DATABASE [OnlineQuiz] SET  READ_WRITE 
GO
