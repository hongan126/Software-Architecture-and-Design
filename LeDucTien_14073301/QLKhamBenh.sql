USE [master]
GO

/****** Object:  Database [QLKhamBenh]    Script Date: 2/21/2017 11:14:05 AM ******/
CREATE DATABASE [QLKhamBenh]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLKhamBenh', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\QLKhamBenh.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLKhamBenh_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\QLKhamBenh_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO

ALTER DATABASE [QLKhamBenh] SET COMPATIBILITY_LEVEL = 130
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLKhamBenh].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [QLKhamBenh] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [QLKhamBenh] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [QLKhamBenh] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [QLKhamBenh] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [QLKhamBenh] SET ARITHABORT OFF 
GO

ALTER DATABASE [QLKhamBenh] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [QLKhamBenh] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [QLKhamBenh] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [QLKhamBenh] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [QLKhamBenh] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [QLKhamBenh] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [QLKhamBenh] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [QLKhamBenh] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [QLKhamBenh] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [QLKhamBenh] SET  DISABLE_BROKER 
GO

ALTER DATABASE [QLKhamBenh] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [QLKhamBenh] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [QLKhamBenh] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [QLKhamBenh] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [QLKhamBenh] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [QLKhamBenh] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [QLKhamBenh] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [QLKhamBenh] SET RECOVERY FULL 
GO

ALTER DATABASE [QLKhamBenh] SET  MULTI_USER 
GO

ALTER DATABASE [QLKhamBenh] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [QLKhamBenh] SET DB_CHAINING OFF 
GO

ALTER DATABASE [QLKhamBenh] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [QLKhamBenh] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [QLKhamBenh] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [QLKhamBenh] SET QUERY_STORE = OFF
GO

USE [QLKhamBenh]
GO

ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO

ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO

ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO

ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO

ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO

ALTER DATABASE [QLKhamBenh] SET  READ_WRITE 
GO


USE [QLKhamBenh]
GO

/****** Object:  Table [dbo].[bacsy]    Script Date: 2/21/2017 11:14:26 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bacsy](
	[msbacsy] [varchar](25) NOT NULL,
	[hotenbacsy] [nvarchar](150) NOT NULL,
 CONSTRAINT [PK_bacsy] PRIMARY KEY CLUSTERED 
(
	[msbacsy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


USE [QLKhamBenh]
GO

/****** Object:  Table [dbo].[khambenh]    Script Date: 2/21/2017 11:14:49 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[khambenh](
	[msbn] [varchar](15) NOT NULL,
	[msbacsy] [varchar](25) NOT NULL,
	[ngaykham] [date] NOT NULL,
	[ghichu] [text] NULL,
 CONSTRAINT [PK_khambenh] PRIMARY KEY CLUSTERED 
(
	[msbn] ASC,
	[msbacsy] ASC,
	[ngaykham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

ALTER TABLE [dbo].[khambenh]  WITH CHECK ADD  CONSTRAINT [FK_khambenh_bacsy] FOREIGN KEY([msbacsy])
REFERENCES [dbo].[bacsy] ([msbacsy])
GO

ALTER TABLE [dbo].[khambenh] CHECK CONSTRAINT [FK_khambenh_bacsy]
GO

ALTER TABLE [dbo].[khambenh]  WITH CHECK ADD  CONSTRAINT [FK_khambenh_benhnhan] FOREIGN KEY([msbn])
REFERENCES [dbo].[benhnhan] ([msbn])
GO

ALTER TABLE [dbo].[khambenh] CHECK CONSTRAINT [FK_khambenh_benhnhan]
GO


