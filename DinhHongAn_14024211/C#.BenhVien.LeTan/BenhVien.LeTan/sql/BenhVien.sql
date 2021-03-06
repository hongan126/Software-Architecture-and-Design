USE [master]
GO
/****** Object:  Database [BenhVien]    Script Date: 02/26/2017 21:54:18 ******/
CREATE DATABASE [BenhVien] 
GO
USE [BenhVien]
GO
CREATE TABLE [dbo].[benhnhan](
	[msbn] [varchar](15) NOT NULL,
	[socmnd] [varchar](25) NULL,
	[hoten] [varchar](150) NOT NULL,
	[diachi] [varchar](250) NULL,
 CONSTRAINT [PK_benhnhan] PRIMARY KEY CLUSTERED 
(
	[msbn] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[benhnhan] ([msbn], [socmnd], [hoten], [diachi]) VALUES (N'@msbn', N'163348420', N'Nguyen Van Aasdasdasd', N'Tp. HCMA')
INSERT [dbo].[benhnhan] ([msbn], [socmnd], [hoten], [diachi]) VALUES (N'bn0001', N'163348420', N'Nguyen Van A', N'Tp. HCMA')
INSERT [dbo].[benhnhan] ([msbn], [socmnd], [hoten], [diachi]) VALUES (N'bn0002', N'173348421', N'Nguyen Van B', N'Binh Thanh, Tp. HCM')
INSERT [dbo].[benhnhan] ([msbn], [socmnd], [hoten], [diachi]) VALUES (N'bn0003', N'183348422', N'Nguyen Van C', N'Tp. HCM')
INSERT [dbo].[benhnhan] ([msbn], [socmnd], [hoten], [diachi]) VALUES (N'bn0004', N'193348423', N'Nguyen Van D', N'Tp. HCM')
/****** Object:  Table [dbo].[bacsy]    Script Date: 02/26/2017 21:54:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bacsy](
	[msbacsy] [varchar](25) NOT NULL,
	[hotenbacsy] [varchar](150) NOT NULL,
 CONSTRAINT [PK_bacsy] PRIMARY KEY CLUSTERED 
(
	[msbacsy] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[bacsy] ([msbacsy], [hotenbacsy]) VALUES (N'bs1001', N'Dinh Hoang A')
INSERT [dbo].[bacsy] ([msbacsy], [hotenbacsy]) VALUES (N'bs1002', N'Dinh Hoang B')
INSERT [dbo].[bacsy] ([msbacsy], [hotenbacsy]) VALUES (N'bs1003', N'Dinh Hoang C')
/****** Object:  Table [dbo].[khambenh]    Script Date: 02/26/2017 21:54:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[khambenh](
	[msbn] [varchar](15) NOT NULL,
	[msbacsy] [varchar](25) NOT NULL,
	[ngaykham] [date] NOT NULL,
	[ghichu] [text] NULL,
 CONSTRAINT [PK_khambenh_1] PRIMARY KEY CLUSTERED 
(
	[msbn] ASC,
	[msbacsy] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK_khambenh_bacsy]    Script Date: 02/26/2017 21:54:20 ******/
ALTER TABLE [dbo].[khambenh]  WITH CHECK ADD  CONSTRAINT [FK_khambenh_bacsy] FOREIGN KEY([msbacsy])
REFERENCES [dbo].[bacsy] ([msbacsy])
GO
ALTER TABLE [dbo].[khambenh] CHECK CONSTRAINT [FK_khambenh_bacsy]
GO
/****** Object:  ForeignKey [FK_khambenh_benhnhan]    Script Date: 02/26/2017 21:54:20 ******/
ALTER TABLE [dbo].[khambenh]  WITH CHECK ADD  CONSTRAINT [FK_khambenh_benhnhan] FOREIGN KEY([msbn])
REFERENCES [dbo].[benhnhan] ([msbn])
GO
ALTER TABLE [dbo].[khambenh] CHECK CONSTRAINT [FK_khambenh_benhnhan]
GO
